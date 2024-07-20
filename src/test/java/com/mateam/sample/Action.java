package com.mateam.sample;

@FunctionalInterface
public interface Action {
//    void execute();

    void perform(Facts facts);
}
