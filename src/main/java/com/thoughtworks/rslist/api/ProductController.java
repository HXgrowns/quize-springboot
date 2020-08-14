package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.exception.CommonError;
import com.thoughtworks.rslist.exception.InvalidIndexException;
import com.thoughtworks.rslist.response.ProductResponse;
import com.thoughtworks.rslist.service.RsEventService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@ControllerAdvice
public class ProductController {

    private final RsEventService rsEventService;

    public ProductController(RsEventService rsEventService) {
        this.rsEventService = rsEventService;
    }

    @PostMapping("/product")
    public ResponseEntity add(@RequestBody Product product) {
        rsEventService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //@GetMapping("/rs/{id}")
    //public ResponseEntity findRsEventById(@PathVariable int id) throws InvalidIndexException {
    //    return ResponseEntity.ok(rsEventService.findById(id));
    //}
    //
    //@GetMapping(value = "/rsEvents")
    //public ResponseEntity<Page<ProductResponse>> findListByPage(@RequestParam(required = false, defaultValue = "10") Integer size, @RequestParam(required = false, defaultValue = "0") Integer page) {
    //    return ResponseEntity.ok(rsEventService.findListByPage(size, page));
    //}
    //
    //@PatchMapping(value = "/rs/{id}")
    //public ResponseEntity<Object> update(@PathVariable int id, @RequestBody ProductEntity inputProductEntity) {
    //    ProductEntity rs = rsEventService.update(id, inputProductEntity);
    //    return ResponseEntity.status(HttpStatus.CREATED).header("index", rs.getId() + "").build();
    //}
    //
    //@DeleteMapping("/rs/{id}")
    //public ResponseEntity deleteById(@PathVariable Integer id) {
    //    rsEventService.deleteById(id);
    //    return ResponseEntity.ok().build();
    //}
    //
    //@PostMapping(value = "/rs/vote/{id}")
    //public ResponseEntity<Object> vote(@PathVariable int id,
    //                                   @RequestParam int userId,
    //                                   @RequestParam int voteNum) {
    //    rsEventService.vote(id, userId, voteNum);
    //    return ResponseEntity.status(HttpStatus.CREATED).build();
    //}
    //
    //@ExceptionHandler(RuntimeException.class)
    //public ResponseEntity exceptionHandler(RuntimeException e) {
    //    CommonError commonError = new CommonError();
    //    commonError.setError(e.getMessage());
    //
    //    return ResponseEntity.badRequest().body(commonError);
    //}
}
