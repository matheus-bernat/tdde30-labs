package se.liu.ida.dinadress.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;

public class Queue
{
    private List<Person> elements = new ArrayList<>();

    public int size() { return elements.size(); }

    public boolean isEmpty() { return elements.isEmpty(); }

    public void clear() { elements.clear(); }

    public boolean contains() { return elements.contains(elements); }

    public void enqueue(Person person) {
        this.elements.add(person);
    }

    public Person dequeue() {
        Person firstPerson = this.elements.get(0);
        for (int i = 0; i < this.size(); i++) {
            if (i == 0) {
                this.elements.remove(0);
            }
        }
        return firstPerson;
    }

}






