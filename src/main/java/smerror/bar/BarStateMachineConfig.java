package smerror.bar;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import smerror.foo.FooEvent;
import smerror.foo.FooState;

@Configuration
@EnableStateMachineFactory(name = "Bar", contextEvents = false)
public class BarStateMachineConfig extends StateMachineConfigurerAdapter<BarState, BarEvent> {

    @Autowired
    public BarStateMachineConfig(StateMachineFactory<FooState, FooEvent> fooStateMachineFactory) {
    }

    //    @Autowired
    //    private StateMachineFactory<FooState, FooEvent> fooStateMachineFactory;

    @Override
    public void configure(StateMachineStateConfigurer<BarState, BarEvent> states) throws Exception {
        states.withStates()
                .initial(BarState.BAR_START)
                .states(new HashSet<>(Arrays.asList(BarState.values())));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<BarState, BarEvent> transitions) throws Exception {
        transitions.withExternal()
                .source(BarState.BAR_START)
                .event(BarEvent.BAR_EVENT)
                .target(BarState.BAR_END);
    }

}
