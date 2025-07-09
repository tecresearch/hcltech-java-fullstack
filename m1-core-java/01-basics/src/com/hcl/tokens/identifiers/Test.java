package com.hcl.tokens.identifiers;
class Test {
    int value = 10;

    void show() {
        int value = 20; // shadows the class-level 'value'
        System.out.println(value); // prints 20
    }
}
