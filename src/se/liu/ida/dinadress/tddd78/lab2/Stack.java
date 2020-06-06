package se.liu.ida.dinadress.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;

public class Stack
{
    private List<Person> elements = new ArrayList<>();

    public int size() { return elements.size(); }

    public boolean isEmpty() { return elements.isEmpty(); }

    public void clear() { elements.clear(); }

    public boolean contains() { return elements.contains(elements); }

    public void push(Person person) {
        this.elements.add(person);
    }

    public Person pop() {
        /*
        Person lastPerson = elements.get(size()-1);
        for (int i = 0; i < size(); i++) {
            if (i == 0) {

            }
        }*/
        return  elements.remove(size() - 1);//lastPerson;
    }
    
}






