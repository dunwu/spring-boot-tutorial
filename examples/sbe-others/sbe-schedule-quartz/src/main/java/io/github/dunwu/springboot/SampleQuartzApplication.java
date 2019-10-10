package io.github.dunwu.springboot;

import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleQuartzApplication.class, args);
    }

//    @Bean
//    public JobDetail sampleJobDetail() {
//        return JobBuilder.newJob(SampleJob.class)
//                         .withIdentity("sampleJob")
//                         .usingJobData("name", "World")
//                         .storeDurably()
//                         .build();
//    }
//
//    @Bean
//    public Trigger sampleJobTrigger() {
//        SimpleScheduleBuilder scheduleBuilder =
//            SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
//
//        return TriggerBuilder.newTrigger()
//                             .forJob(sampleJobDetail())
//                             .withIdentity("sampleTrigger")
//                             .withSchedule(scheduleBuilder)
//                             .build();
//    }

}
