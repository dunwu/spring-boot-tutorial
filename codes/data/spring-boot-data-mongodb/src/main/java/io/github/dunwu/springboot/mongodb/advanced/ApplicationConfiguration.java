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
package io.github.dunwu.springboot.mongodb.advanced;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Test configuration to connect to a MongoDB named "test" and using a {@code MongoClient} with profiling enabled.
 * @author Christoph Strobl
 */
@SpringBootApplication
class ApplicationConfiguration {

    static final String SYSTEM_PROFILE_DB = "system.profile";

    @Autowired
    MongoOperations operations;

    /**
     * Initialize db instance with defaults.
     */
    @PostConstruct
    public void initializeWithDefaults() {

        // Enable profiling
        setProfilingLevel(2);
    }

    /**
     * Clean up resources on shutdown
     */
    @PreDestroy
    public void cleanUpWhenShuttingDown() {

        // Disable profiling
        setProfilingLevel(0);

        if (operations.collectionExists(SYSTEM_PROFILE_DB)) {
            operations.dropCollection(SYSTEM_PROFILE_DB);
        }
    }

    private void setProfilingLevel(int level) {
        operations.executeCommand(new Document("profile", level));
    }

}
