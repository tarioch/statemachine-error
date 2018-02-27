package smerror.foo;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachineFactory(name = "Foo", contextEvents = false)
public class FooStateMachineConfig extends StateMachineConfigurerAdapter<FooState, FooEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<FooState, FooEvent> states) throws Exception {
        states.withStates()
                .initial(FooState.FOO_START)
                .states(new HashSet<>(Arrays.asList(FooState.values())));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<FooState, FooEvent> transitions) throws Exception {
        transitions.withExternal()
                .source(FooState.FOO_START)
                .event(FooEvent.FOO_EVENT)
                .target(FooState.FOO_END);
    }

}
