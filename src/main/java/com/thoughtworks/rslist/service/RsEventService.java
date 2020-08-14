package com.thoughtworks.rslist.service;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.ProductRepository;

import org.springframework.transaction.annotation.Transactional;

public class RsEventService {

    private final ProductRepository productRepository;

    public RsEventService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void save(Product product) {
        ProductEntity productEntity = product.build();
        productRepository.save(productEntity);
    }

    //@Transactional
    //public void deleteByUserId(Integer id) {
    //    productRepository.deleteByUserId(id);
    //}
    //
    //@Transactional
    //public ProductEntity update(int id, ProductEntity inputProductEntity) {
    //    int userId = Optional.ofNullable(inputProductEntity)
    //            .map(ProductEntity::getUser).orElseThrow(() -> new InvalidRsEventException("user is null"))
    //            .getId();
    //
    //    ProductEntity findedProductEntity = productRepository.findById(id).orElseThrow(() -> new InvalidRsEventException("rsEvent is not exists"));
    //
    //    if (findedProductEntity.getUser() == null || findedProductEntity.getUser().getId() != userId) {
    //        throw new InvalidRsEventException("userId is required");
    //    }
    //
    //    findedProductEntity.setKeyword(inputProductEntity.getKeyword() != null ? inputProductEntity.getKeyword() : findedProductEntity.getKeyword());
    //    findedProductEntity.setEventName(inputProductEntity.getEventName() != null ? inputProductEntity.getEventName() : findedProductEntity.getEventName());
    //    return productRepository.save(findedProductEntity);
    //}
    //
    //@Transactional
    //public void vote(int id, int userId, int voteNum) {
    //    if (!productRepository.existsById(id)) {
    //        throw new InvalidRsEventException("reEvent is not exists");
    //    }
    //
    //    UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new InvalidRsEventException("user is not exists"));
    //
    //    if (userEntity.getVote() < voteNum) {
    //        throw new InvalidRsEventException("user total voteNum < voteNum");
    //    }
    //
    //    VoteEntity voteEntity = VoteEntity.builder()
    //            .user(userEntity)
    //            .productEntity(ProductEntity.builder().id(id).build())
    //            .voteNum(voteNum)
    //            .voteTime(LocalDateTime.now())
    //            .build();
    //
    //    voteRepository.save(voteEntity);
    //    productRepository.updateVoteNum(voteNum, id);
    //    userRepository.updateVoteNum(voteNum, userId);
    //}
    //
    //public ProductResponse findById(int id) {
    //    return productRepository.findById(id).orElseThrow(() -> new InvalidRsEventException("rsEvent is not exists")).build();
    //}
    //
    //public Page<ProductResponse> findListByPage(Integer size, Integer page) {
    //    return productRepository.findAll(PageRequest.of(page, size)).map(ProductEntity::build);
    //}
    //
    //public void deleteById(Integer id) {
    //    if (!productRepository.findById(id).isPresent()) {
    //        throw new InvalidIndexException("rsEvent is not exists");
    //    }
    //    productRepository.deleteById(id);
    //}
}
