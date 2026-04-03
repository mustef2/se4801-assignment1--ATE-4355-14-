//ATE/4355/14
package com.shopwave.repository;

import com.shopwave.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}