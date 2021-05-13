/*
 * Copyright 2014-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.dunwu.springboot.mongodb.customer;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

/**
 * An entity to represent a customer.
 * @author Oliver Gierke
 */
@Data
@Document
public class Customer {

    private String id, firstname, lastname;
    private Address address;

    /**
     * Creates a new {@link Customer} with the given firstname and lastname.
     * @param firstname must not be {@literal null} or empty.
     * @param lastname  must not be {@literal null} or empty.
     */
    public Customer(String firstname, String lastname) {

        Assert.hasText(firstname, "Firstname must not be null or empty!");
        Assert.hasText(lastname, "Lastname must not be null or empty!");

        this.firstname = firstname;
        this.lastname = lastname;
    }

}
