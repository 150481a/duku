package org.duku.mall.framework.starter.designpattern.chain;

import org.duku.mall.frameworks.starter.bases.ApplicationContextHolder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 抽象责任链上下文
 * “抽象责任链上下文”表示在责任链模式中，将请求的处理环境抽象为上下文对象，并在责任链中进行传递。每个处理器根据上下文中的信息来决定是否处理请求或者传递给下一个处理器。这种设计通过解耦请求处理者与请求发送者，并利用上下文信息，使系统具有更好的扩展性和灵活性。
 */
public class AbstractChainContext<T> implements CommandLineRunner {
   private final Map<String, List<AbstractChainHandler>> abstractChainHandlerContainer=new HashMap<>();


    /**
     * 注册责任链处理器
     * @param mark
     * @param requestParam
     */
   public void handler(String mark, T requestParam) {
       List<AbstractChainHandler> abstractChainHandlers = abstractChainHandlerContainer.get(mark);
       if (CollectionUtils.isEmpty(abstractChainHandlers))
           throw new RuntimeException(String.format("[%s] Chain of Responsibility ID is undefined.", mark));

       abstractChainHandlers.forEach(abstractChainHandler -> abstractChainHandler.handler(requestParam));

   }


    /**
     * 初始化责任链处理器
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Map<String, AbstractChainHandler> chainFilterMap =  ApplicationContextHolder.getBeansOfType(AbstractChainHandler.class);
        chainFilterMap.forEach((beanName, bean) -> {
            List<AbstractChainHandler> abstractChainHandlers = abstractChainHandlerContainer.get(beanName);
            if(CollectionUtils.isEmpty(abstractChainHandlers))
                abstractChainHandlers=new ArrayList<>();

            abstractChainHandlers.add(bean);
            List<AbstractChainHandler> collect = abstractChainHandlers.stream()
                    .sorted(Comparator.comparing(Ordered::getOrder))
                    .collect(Collectors.toList());
            abstractChainHandlerContainer.put(beanName, collect);
        });
    }
}
