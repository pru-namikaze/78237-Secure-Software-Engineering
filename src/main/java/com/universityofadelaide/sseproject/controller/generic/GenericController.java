package com.universityofadelaide.sseproject.controller.generic;

import com.universityofadelaide.sseproject.model.generic.GenericModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class GenericController<T extends GenericModel<T>, R extends CrudRepository<T, Long>> {

    @Autowired
    public R repository;
    @GetMapping("/heartBeat")
    public ResponseEntity<String> heartBeat(){
        return ResponseEntity.ok("Controller up");
    }
    public ResponseEntity<T> updateParametersIfPresent(T dataCell) {
        return Optional.of(this.getById(dataCell.getId()))
                .filter(response -> response.getStatusCode().is2xxSuccessful())
                .filter(ResponseEntity::hasBody)
                .map(HttpEntity::getBody)
                .map(dataCell1 -> dataCell1.updateParametersIfPresent(dataCell))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/createOrUpdate.json")
    public ResponseEntity<T> createOrUpdate(@RequestBody T dataCell) {
        return Optional.of(this.repository.save(dataCell))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/create.json")
    public ResponseEntity<T> create(@RequestBody T dataCell) {
        return this.createOrUpdate(dataCell);
    }

    @GetMapping("/getById.json")
    public ResponseEntity<T> getById(@RequestParam Long id) {
        return Optional.of(this.getByIds(List.of(id)))
                .filter(response -> response.getStatusCode().is2xxSuccessful())
                .filter(ResponseEntity::hasBody)
                .map(HttpEntity::getBody)
                .filter(list -> !list.isEmpty())
                .map(List::iterator)
                .filter(Iterator::hasNext)
                .map(Iterator::next)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/getByIds.json")
    public ResponseEntity<List<T>> getByIds(@RequestBody List<Long> ids) {
        return Optional.of(this.repository.findAllById(ids))
                .filter(itr -> itr.iterator().hasNext())
                .map(itr -> StreamSupport.stream(itr.spliterator(), false).collect(Collectors.toList()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/getAll.json")
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(
                StreamSupport.stream(this.repository.findAll().spliterator(), false).collect(Collectors.toList())
        );
    }

    @PostMapping("/updateById.json")
    public ResponseEntity<T> updateById(@RequestBody T dataCell) {
        return Optional.of(updateParametersIfPresent(dataCell))
                .filter(response -> response.getStatusCode().is2xxSuccessful())
                .filter(ResponseEntity::hasBody)
                .map(HttpEntity::getBody)
                .map(this::createOrUpdate)
                .filter(response -> response.getStatusCode().is2xxSuccessful())
                .orElse(ResponseEntity.badRequest().build());
    }
}
