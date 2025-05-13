package org.duku.mall.framework.starter.common.common.sensitive.quartz;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail sensitiveQuartzDetail() {
        return JobBuilder.newJob(SensitiveQuartz.class).withIdentity("sensitiveQuartz").storeDurably().build();
    }

    @Bean
    public Trigger sensitiveQuartzTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(3600)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(sensitiveQuartzDetail())
                .withIdentity("sensitiveQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
