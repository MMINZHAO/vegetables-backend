package com.vageables.shop.repository;

import com.vageables.shop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 12:57
 * @description : --AddressRepository类描述--
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAllByUserid(Integer userid);
}
