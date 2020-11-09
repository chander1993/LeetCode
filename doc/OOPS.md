## Interface
* helps loose coupling.
This allows for extensibility in software design; a new class implementing an interface can be written to replace a current dependency in some or all situations, without requiring a change to the dependent class; the new and old classes can be interchanged freely. Strong coupling does not allow this.
* 

## Encapsulation
* bundling the data and methods that operate on data within one unit.
* hiding the state of the object inside the class.

```
// 'class' helps to bundle the data and methods into a single unit
class Account {

    // private 'access=modifier' helps to hide the state of the object.
    private balance;

    // access the state of the object in more controlled manner
    public void setBalance(float amount) {
        if(balance < 0) {
            throw Exception;
        }

        this.balance = amount;
    }
}
```

## Abstraction
* reduce complexity by hiding unneccessary details.

Advantages
* This concept helps to reduce complexity for the consumers.
* we can change the implementation of hidden methods confidently without affecting any of the consumers of this class.

Example: imagine a TV remote with thousands of button.
```
public class MailService {
    public void sendEmail() {
        connect();
        authenticate();
        // Send email
        disconnect();
    }

    // these methods need not be visible to the consumer of this class.
    // this will add complexity and confuse because its more of implementation detail.
    // we can change the access modifier of these methods to private to hide the implmentation details of the sendEmail()
    public void connect() {

    }

    public void disconnect() {


    }

    public void authenticate() {

    }
}

public class Main {
    public static void main(String[] args) {
        MailService mailService = new MailService();
        mailService.sendEmail();
    }
}
```

## Inheritance
* mechanism for reusing the code through is-a relationship.

```
//TextBox
//Button

//enable()
//focus()
//setPosition()

class UIControl {
    public void enable() {
        System.out.println("enabled");
    }

    public void focus() {

    }

    public void setPosition() {

    }
}

// enable(), focus(), setPosition() is already available because of 'extends' keyword
public class TextBox  extends UIControl {

}

public class Button extends UIControl {

}
```

## Polymorphism
* many forms : abilty of the code to take may forms.
* achieved via overloading and overriding

Advantage:
* code reusablity. a generic method can be written to handle all the shapes.
```
//Square
//Circle

// draw() : different for different shapes

abstract class Shape {

    public abstract void draw();
}

// enable(), focus(), setPosition() is already available because of 'extends' keyword
public class TextBox  extends UIControl {
    @Override
    public void draw() {
        
    }
}

public class Button extends UIControl {
     @Override
    public void draw() {
        
    }
}

class Main {
    public static void main(String[] args) {
        drawShape(new Square());
    }

    public static void drawShape(Shape shape) {
        shape.draw();
    }
}
```

## SolidPrinciples
https://medium.com/successivetech/s-o-l-i-d-the-first-5-principles-of-object-oriented-design-with-php-b6d2742c90d7#:~:text=SOLID%20is%20an%20acronym%20of,maintainable%20and%20extensible%20software%20systems.&text=Open%2FClosed%20principle,Interface%20Segregation%20principle
S - Single Responsiblity  <br/>
O - Open / Closed   <br/>
L - Liskov Substitution principle   <br/>
I - Interface seggregation pattern  <br/>
D - Dependency inversion principle  <br/>


