package smerror;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;

import smerror.bar.BarEvent;
import smerror.bar.BarState;
import smerror.foo.FooEvent;
import smerror.foo.FooState;

@Component
public class SimpleAppRunner {

    @Autowired
    private StateMachineFactory<FooState, FooEvent> fooStateMachineFactory;
    @Autowired
    private StateMachineFactory<BarState, BarEvent> barStateMachineFactory;

    public void run() {
        System.out.println(fooStateMachineFactory.getStateMachine());

        System.out.println(barStateMachineFactory.getStateMachine());
    }

}
