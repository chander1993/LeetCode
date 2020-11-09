## Singleton
### Eager Initialization:
Pros:
* Very simple to implement.
Cons:
* May lead to resource wastage. Because instance of class is created always, whether it is required or not.
* CPU time is also wasted in creation of instance if it is not required.
* Exception handling is not possible. (Alternatively we can use static block to create object and handle exceptions.)
```
// Eager initialization
public class Singleton {
    
    // create single instance while class loading
    public static Singleton instance = new Singleton();

    // mark the constructor as private
    private Singleton() {

    }

    // factory method to always return the same created object
    public static Singleton getInstance() {
        return instance;
    }
}
```
### Lazy Initialization
inner class is not loaded until getInstance method is called.

Thread safe as well as lazy initialization. most widely used because of it simplicity.
```
public class Singleton {

    // Private constructor
    private Singleton() {

    }

    // Inner class  to provide instance of class
    public static class SingletonFactory {
        public static final Singleton INSTANCE = new Singleton(); 
    }

    public static Singleton getInstance() {
        return SingletonFactory.INSTANCE;
    }
}
```

Another method with Double locking:

```
public class Singleton {

    public static Singleton INSTANCE;
    
    // private constructor
    private Singleton() {

    }

    // double locking just to ensure singleton in a multi threaded environment
    public static Singleton getInstance() {
        if(INSTANCE == null) {
            synchornized(Singleton.class) {
               if(instance == null)
                INSTANCE = new Singleton();
            }
        } 
        
        return INSTANCE;
    }

}
```




## Factory

```
public interface Shape {

}

public class Square implements Shape {

}

public class Rectangle implements Shape {

}

class ShapeFactory {
    public Shape getInstance(String type) {
        if(type == null) {
            return null;
        }

        switch(type) {
            case "SQUARE" : return new Shape();
            case "RECTANGLE" : return new Rectangle();
            default: retun null;
        }
    }
}
```
```
// with Generics

interface Cache<K, V> {
    public void put(K key, V value);
    public V get(K key);
}

class LRU<K, V> implements Cache<K, V> {
    public Map<K, V> map = new LinkedHashMap<>();

    @Override
    public void put(K key, V value) {
        System.out.println("LRU PUT");
    }
    
    @Override
    public V get(K key) {
          System.out.println("LRU GET");
        return null;
    }
}

class LFU<K, V> implements Cache<K, V> {
    @Override
    public void put(K key, V value) {
          System.out.println("LFU PUT");
    }
    
    @Override
    public V get(K key) {
        System.out.println("LFU GET");
        return null;
    }
}

class CacheFactory<K, V> {
    public Cache<K, V> getInstance(String type) {
        if(type == null) {
            return null;
        }
        
        if(type.equals("LRU")) {
            return new LRU<K, V>();
        }
        
        return null;
    }
}

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        CacheFactory<String, Integer> cacheFactory = new CacheFactory<>();
        Cache<String, Integer> cache = cacheFactory.getInstance("LRU");
        cache.get("test");
        
     }
}
```
## Immutable
```
public final class Immutable {

    private final String attribute;

    public Immutable(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return this.attribute;
    }
}
```

## Flyweight pattern
1. a factory class storing the already created objects and returning when same object is requested.
thus reducing the number of newly created objects.
https://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm

## Builder pattern

```
public class Acccount {
    private int accountNumber;
    private String name;

    public static class Builder {
        private int accountNumber;
        private String name;
        public Builder() {

        }

        public Builder withAccountnumber(int accountNumber) {
            this.accountNumber = accountNumber; 
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.accountNumber = this.accountNumber;
            account.name = this.name;
            return account;
        }
    }

}
```

## Strategy Design Pattern

* chaning the behaviour of the class at the runtime.
* this is genearlly achieved with the help of interface.

```
public interface Strategy{
    public int doOperation(int a, int b);
}

public class Add implements Strategy {

 @Override
 public int doOperation(int a, int b) {
     return a + b;
 }
}

public class Subract implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}

```

## Decorator Design pattern:

## SAGA design pattern
* solves the problem for distributed transactions.

Generally,
Order service(transaction id is created) --- sends a message to wallet and product service----> if both the services retruns success then marks the transaction as success. if either one of them responds with a failure message fail the transaction. in either case send appropriate message to customer.

Door commands service ----- sends event to service activation and remote status validation service ----> responds with validation results -----if success---> send command event to command service ----> executes it in the car and sends back the result as event.

## API composition
* solves the problem of implementing complex queries to multiple services in a microservices architecture to retreive some data.

API composer invokes other microservices and does an in memory join of the data and returns to the customer.

## CQRS design pattern


## Event sourcing