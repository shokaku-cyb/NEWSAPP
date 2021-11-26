package com.maoyingjie.newapps.ui.ViewState;

public class StatefulData<T> {
    public T data;
    public State state;

    public StatefulData(T data, State state) {
        this.data = data;
        this.state = state;
    }

    public <T> StatefulData<T> success(T data,State state) {
        return new StatefulData<>(data,state);
    }
}
