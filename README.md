# 设计模式 GRASP & GoF

标签（空格分隔）： web

---

> 借用公开课 Justice 中的话，了解设计模式不一定能让我们解决软件设计与开发中的问题，但能让我们在遇到问题时，思考的方式不至鲁莽与茫然。

## 五大设计原则
面向对象软件设计具有五大基本原则（首字母缩写为：SOLID）：
### 单一职责原则
单一职责原则（SRP：Single Responsibility Principle）：不要让一个类承担过多的职责，就一个类而言，应该仅有一个引起它变化的原因。
### 开放闭合原则
开闭原则（OCP：Open-Close Priciple）：保证类对扩展开放，而对修改封闭。
### 李氏替换原则
里氏代换（LSP：The Liskov Substitution Principle）：子类必须能够替换掉它们的父类。
### 接口隔离原则
接口隔离原则（ISP：The Interface Segregation priciple）：客户端不应该依赖它不需要的接口；一个类对另一个类的依赖应该建立在最小的接口上；不要让类实现含有无用方法的接口。
### 依赖倒置原则
依赖倒转(DIP：Dependency Inversion Principle)：高层次的模块不应该依赖于低层次的模块，他们都应该依赖于抽象；抽象不应该依赖于具体，具体应该依赖于抽象。

> 以下对 GRASP & GoF 所代表的设计模式进行介绍，这些设计模式并非完全按照以上基本原则，有的甚至为了解决某一类问题而破坏这些原则。

## GRASP
通用责任链分配模式的核心思想是职责分配（Responsibility Assignment）。

### 专家模式（Expert Pattern）
#### 介绍
专家模式要求将请求的处理交由信息的所有者。
#### 缺点
可能会导致信息专家对象承担过多的职责。
#### 示例
考虑登录需求，在控制器中，将登录验证逻辑交由拥有登录所需信息的类来进行，而不是控制器本身。
#### 类图

![专家模式][1]

#### 核心代码
```
public class Controller {
    public String login(){
        User user = new User("username", "password");
        boolean canLogin = user.login();
        if(canLogin){
            return "www.website.com/index";
        }else{
            return "www.website.com/error.401.php";
        }
    }
}
```

### 控制器模式（Controller Pattern）
#### 介绍
控制器模式要求模块能够接受请求，并将请求转发到业务处理模块，且按照处理模块的处理结果反馈响应（MVC 模式）。
#### 缺点
控制器承担了过多职责，控制器往往与大量类存在耦合。
#### 示例
MVC 模式中的控制器层。
#### 类图

![控制器模式][2]

注意，`View` 类也可以直接调用 `Model` 类。
#### 核心代码
```
public class Controller {
    public Object dispatch(Object request){
        Model model = new Model();
        Object res = model.handle(request);
        return res;
    }
}
```

### 创建者模式（Creator Pattern）
#### 介绍
创建者模式定义了一些标准，要求在以下情况下，A 类对象需要是 B 类对象的创建者：
1. A 类对象是 B 类对象的聚合体；
2. A 类对象包含 B 类对象；
3. A 类对象使用 B 类对象；
4. A 类对象记录 B 类对象状态；
5. A 类对象拥有创建 B 类对象的数据/信息。
#### 缺点
由于以上关系可能存在于大量类之间，导致 B 类的创建过程难以统一。

## GoF 

GoF：Gang of Four，指被称为设计模式先驱的四人：Erich Gamma、Richard Helm、Ralph Johnson 和 John Vlissides。他们提出了以下 23 种设计模式，且这些设计模式又可被分为创建型模式、结构型模式，以及行为型模式。

## GoF - 创建型模式
### 单例模式（Singleton Pattern）
#### 介绍
确保类中只有一个实例，试图获取这一类的逻辑代码所得到的对象均为同一个。
#### 缺点
在多线程编程中需要保证访问的同步。
#### 示例
如获取配置文件的内容，由于配置文件在项目运行后一般不会再修改，所以配置对象可以采用单例模式实现。
#### 类图
![单例模式][3]
#### 核心代码
```
public class Config {
    private static Config config = null;
    // 私有化构造方法
    private Config() {}
    /**
     * 当对象为空时，先创建再返回
     * 反之直接返回
     * @return
     */
    public static Config getConfig(){
        if(Config.config == null){
           Config.config = Config.createConfig();
           return Config.getConfig();
        }else{
            return Config.config;
        }
    }
    /**
     * 如果对象的创建过程比较复杂，可以单独抽离一个 createConfig 方法
     * 当然也可以把创建过程直接写在 getConfig 方法之中
     * @return
     */
    private static Config createConfig(){
        return new Config();
    }
}
```
注意：为了让外界不能再调用构造方法，应当将其私有化。此外，在其他语言中，可能还需要将序列化和克隆方法均声明为私有。

### 原型模式（Prototype Pattern）
#### 介绍
通过拷贝原型实例而非重新调用构造方法的方式得到新的对象。
#### 缺点
考虑原型对象的过程可能比较繁琐（涉及深拷贝问题）；且需要特别注意循环引用的问题（类的属性中又包含该类）。
#### 示例
对一类通知对象的构建。通知对象中含有大量的重复属性，如通知头部信息和通知尾部信息。
#### 类图
![原型模式][4]
#### 核心代码
```
public class Message implements Cloneable{
    // 通用头部
    private Object commonHeader = null;
    // 通用尾部
    private Object commonFooter = null;
    // 定制主体
    private Object body;

    @Override
    protected Message clone() throws CloneNotSupportedException {
        Message message = (Message) super.clone();
        // 如果头部和尾部的对象创建过程需要深拷贝，则需要特殊处理这段代码
        message.commonHeader = new Object();
        message.commonFooter = new Object();
        return message;
    }
    public void setBody(Object body) {
        this.body = body;
    }
}
```
注意：在 Java 代码中需要实现 `Cloneable` 接口，而在其他语言中可能需要用其他机制。如 PHP 中，需要重写魔术方法 `__clone()`，并在需要调用时使用 `$obj1 = clone $obj2`。

### 构造器模式（Builder Pattern）
#### 介绍
使得复杂对象的构造过程和表示分离，以便可以复用相同的构造过程。

#### 缺点
每一类产品都需要一个构造器，增加了代码量。

#### 示例
订单可能需要转换为 `XML` 或 `Json` 格式，虽然转换方法本身是不同的，但转换的步骤（转换订单地址、转换配送时间等）是相同的，因而可以使用构造器模式实现。

#### 类图
![构造器模式][5]

注意，虽然 `Client` 依赖箭头指向的是 `OrderJSONBuilder`，但其实际依赖的 `OrderBuilder` 接口。
#### 核心代码
```
public class Client {
    private void doSome(){
        OrderBuilder orderBuilder = new OrderJSONBuilder();
        Director director = new Director(orderBuilder);
        // 采用指导器用统一的过程指导构建
        director.build();
        // 从具体的构造类的获得构造结果
        Object res = orderBuilder.getRes();
    }
}
```
注意，用 `Director` 进行构造过程，而最终的结果是从具体的 `OrderBuilder` 中获得的，`Director` 中的代码为：
```
public class Director {

    private OrderBuilder orderBuilder;

    public Director(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public void build(){
        this.orderBuilder.convertAddr();
        this.orderBuilder.convertFooter();
        this.orderBuilder.convertHeader();
        this.orderBuilder.convertTime();
    }
}
```

### 简单工厂模式（Simple Factory Pattern）
#### 介绍
为了介绍后续的工厂类模式，这里先对简单工厂的实现进行介绍（该模式并不属于 GoF 的 23 种设计模式之一）。简单工厂模式将对象的构建过程统一到一起，在业务代码中需要使用到这一对象时，统一通过工厂类进行构建。这种模式使得对象的构造过程得以统一，让对象构造过程的变化不至于导致大范围的代码修改。此外，当构造过程非常复杂时，采用简单工厂也可以减少代码的冗余。
#### 缺点
构造工厂的引入增加了代码量。
#### 示例
订单对象的构建过程通常需要对样式、实际信息、附加信息等进行构造，相对复杂和麻烦，这时可以使用订单构造工厂来进行实现。
#### 类图
![简单工厂模式][6]
#### 核心代码
```
public class OrderFactory {

    public static Order createOrder(){

        Object style = new Object();
        Object body = new Object();
        Object appendix = new Object();

        Order order = new Order(style, body, appendix);
        return order;
    }
}
```

### 工厂方法模式（Factroy Method Pattern）
#### 介绍
对比简单工厂模式，如果当前需要工厂来进行具体对象的构建，但工厂所要进行的创建过程现在还未可知时，我们便需要考虑使用工厂方法模式进行实现。工厂方法模式将具体的工厂创建行为交由子类实现。

#### 缺点
工厂方法模式进一步聚合了一组构建对象和一组构建它们的工厂。当需要创建新的对象时，新的工厂也需要被定义。

#### 示例
订单的导出过程结果可以是 pdf 形式，也可以是 html 形式，而订单的构造过程为转换格式并导出，对于不同格式的订单构造，只有转换格式这一步是不同的，此时可以考虑使用工厂方法模式。

#### 类图
![工厂方法模式][7]

#### 核心代码
```
abstract public class OrderFactory {

    protected Order order;

    public Order export(){
        this.convert();
        return this.order;
    }

    abstract protected void convert();

}
```
然后，可以在 `Client` 中这样使用：
```
public class Client {

    public void doSome(){

        OrderFactory factory = new PdfOrderFactory();
        Order order = factory.export();

    }
}
```

### 抽象工厂模式（Abstract Factory Pattern）
#### 介绍
类比工厂方法模式，如果创建的对象分为多类，每一类又含有相同的分类时，可以考虑使用抽象工厂模式。该模式为产品族群对象或相互关联对象提供了统一的接口。
#### 缺点
应对产品类型增加这一变化时，抽象工厂模式相对困难。
#### 示例
图表可以分为饼状图、折线图和柱形图，而每一种图表格又可以分为扁平风格和水晶风格。我们可以把这种类型的对象创建过程采用抽象工厂模式进行实现。
#### 类图
![抽象工厂模式][8]

#### 核心代码
`Client` 端使用的方式为：
```
public class Client {

    public void doSome(){
        FlatChartFactory flatChartFactory = new FlatChartFactory();
        CrystalChartFactory crystalChartFactory = new CrystalChartFactory();

        BarChart barChart = flatChartFactory.createBarChart();
        LineChart lineChart = crystalChartFactory.createLineChart();
    }

}
```
`ChartFactory` 的代码为：
```
abstract public class ChartFactory {
    abstract public PieChart createPieChart();
    abstract public LineChart createLineChart();
    abstract public BarChart createBarChart();
}
```
抽象工厂其实是将不同的分类方式巧妙的利用了起来。对于这一示例，如果需要增加 3D 类型的构造工厂，则只需重新实现一个工厂类即可。但若要新增一款产品（如雷达图），则需要改动的代码会相当多。


## GoF - 结构型模式
### 适配器模式（Adapter Pattern）
#### 介绍
通过将原接口转换为目标接口以实现不同对象之间的适配。
#### 缺点
一个适配器只能适应一个目标需求。大量使用适配器可能会导致项目代码层级越来越多。

#### 示例
视图层渲染视图的时候，需要使用某一类型的对象，而业务代码所能提供的是另一种类型。此时可以使用适配器模式来解决问题。

#### 类图
![适配器模式][9]

#### 核心代码
```
public class Controller {

    public void dispatch(){
        Viewer viewer = new Viewer();
        Data originData = new Data();
        DList data = new DataAdapter(originData);
        // 要求传入的 DList 类型的对象，我们借助适配器进行了接口适配
        viewer.render(data);
    }

}
```
这种实现一方接口的适配器被称为对象适配器；如果该适配器同时实现或继承调用者和被调用者双方，则称其为类适配器（可能需要多继承的语法支持）。

### 桥模式（Bridge Pattern）
#### 介绍
桥模式旨在进行抽象层和实现层的分离。
#### 缺点
增加了类设计的数量。
#### 示例
数据库日志类中需要实现对数据库的日志操作，该日志操作又分为 XML 格式日志和 JSON 格式日志。此外，数据库管理类需要依赖数据库操作类实现数据操作，且数据库管理类又存在 MySQL、SQLite 等多种实现。应对这一需求，可以使用桥模式实现。
#### 类图
![桥模式][10]

#### 核心代码
```
public class Client {

   public void doSome(){
       DBOperator operator = new DBMySQLOperator();
       DBLogger logger = new DBXMLLogger();

       logger.setOperator(operator);
       logger.log();
   }

}
```

### 组合模式（Composite Pattern）
#### 介绍
组合模式将聚合体及其内部的组成元素统一当作一种类型看待和操作。
#### 缺点
组合模式要求把聚合体和元素都看作等同的类型，这在一些情况下存在使用的局限性。
#### 示例
被渲染页面中可能存在多个布局模块，模块中的一些部分又可以当作子布局模块，这其中也存在一些非聚合体组件。对于这种需求和情况，可以考虑使用组合模式。
#### 类图
![组合模式][11]
#### 核心代码
视图层基于某一模块进行渲染：
```
public class Viewer {

    public void render(){
        Renderable page = new Module();
        page.draw();
    }

}
```
若模块的某子部分为普通的元素，则直接渲染，若仍为模块，则递归渲染：
```
public class Module implements Renderable {

    private List<Renderable> components = new ArrayList<>();

    @Override
    public void draw() {
        Iterator<Renderable> iterator = this.components.iterator();
        while (iterator.hasNext()){
            iterator.next().draw();
        }
    }
}

```

### 装饰器模式（Decorator Pattern）
#### 介绍
实现动态地向对象中添加功能。

#### 缺点
动态地添加功能，则意味着实际调用对象的功能与原对象不同，导致调试上出现困难。

#### 示例
每一种咖啡都有价格选项，而只有一部分咖啡可以加糖或加牛奶。面对这种对象组织和需求，可以考虑使用装饰器模式。

#### 类图
![装饰器模式][12]
#### 核心代码
```
public class Client {

    public void offer(){
        Coffee coffee = new SimpleCoffee();

        // 加糖
        Coffee coffeWithSuger = new CoffeeSugerDecorator(coffee);

        // 加牛奶
        Coffee coffeeWithMilkAndSuger = new CoffeeMilkDecorator(coffeWithSuger);

    }

}
```

### 门面模式（Facade Pattern）
#### 介绍
为了不把复杂的操作过程统统暴露出去，可以在类中仅定义一个公有方法给外界，而把复杂的过程隐藏在这个方法中。

#### 缺点
暴露的方法的会受到内部实现方法变动的影响。

#### 示例
一次 API 接口的调用可能需要经过很多步骤，如果这些方法统统暴露在外界的话，会增加外部使用这一对象的难度。因而我们可以只留下一个方法，而把复杂的步骤隐藏在这一方法中。

#### 类图
![门面模式][13]
#### 核心代码
在客户端，我们可以只调用暴露的方法：
```
public class Client {

    public void callAPI(){
        APICaller apiCaller = new APICaller();
        Object res = apiCaller.call();
    }

}
```
而把具体的过程隐藏起来：
```
public class APICaller {
    public Object call(){
        Object res = getOriginData();
        res = encryptData(res);
        res = compressData(res);
        return res;
    }

    private Object getOriginData(){
        return new Object();
    }

    private Object encryptData(Object originData){
        // 加密处理
        return originData;
    }

    private Object compressData(Object originData){
        // 压缩
        return originData;
    }
}
```

### 享元模式（Flyweight Pattern）
#### 介绍
享元模式旨在采用共享方式有效使用数量巨大的细粒度对象。
#### 缺点
在向享元管理类申请资源时需要伴随一定的逻辑处理过程，会有资源消耗。
#### 示例
把资源类对象的申请过程交由资源管理类进行，管理类拥有资源池，负责合理地分配和回收资源，以达到资源的最大利用率。

#### 类图
![享元模式][14]
#### 核心代码
```
public class Client {

    public void doSome(){
        ResourcePool pool = new ResourcePool();

        try {
            Object o = pool.apply(4);
        } catch (Exception e) {
            System.out.println("资源申请失败");
            e.printStackTrace();
        }
    }

}
```
在资源管理类中，代码为：
```
public class ResourcePool {

    public ArrayList<Object> resources = new ArrayList<>();

    public Object apply(int index) throws Exception {
        if(resources.size() >= index + 1){

            if(resources.get(index) == null){
                Object flyweight = new Object();
                resources.set(index, flyweight);
            }

            return resources.get(index);

        }else{
            throw new Exception("Invalid request");
        }
    }

}
```
注意，这里实现的是简化的资源申请和管理策略。

### 代理模式（Proxy Pattern）
#### 介绍
为目标对象提供代理对象，从而可以在真正的对象执行逻辑前后插入一些逻辑代码，如日志记录等。
#### 缺点
代理类的引入使得代码的逻辑变得复杂。
#### 示例
在向数据库存取数据操作的前后进行操作类型和花费时间的记录，此时可以考虑使用代理模式。
#### 类图
![代理模式][15]
#### 核心代码
在客户端使用相同的方式调用操作类：
```
public class Client {

    public void doSome(){
        DBOperator operator = new DBOperatorProxy();
        Object o = operator.getData();
    }

}
```
而实际的代码执行过程前后被加入了另外的逻辑：
```
public class DBOperatorProxy implements DBOperator{

    private DBOperator dbOperator = new DBOperatorImpl();

    @Override
    public Object getData() {
        // 前置操作

        Object res = this.dbOperator.getData();

        // 后置操作

        return res;
    }
}
```
注意，这里使用的是静态代理模式，在很多语言中，还可以使用反射机制实现动态代理甚至面向切面开发。

## GoF - 行为型模式
### 责任链模式（Chain of Responsibility Pattern）
#### 介绍
当处理某一请求需要多个步骤，且这多个步骤之间可以以某一顺序依次进行时，可以使用责任链模式。
#### 缺点
责任链模式虽然串联了解决问题的步骤，但并未保证问题一定可以在链上被处理。
#### 示例
订单验证功能可能需要多层验证机制才能确保无误，此时可以使用责任链模式进行实现。
#### 类图
![责任链模式][16]
#### 核心代码
在客户端中，只需调用首位验证器即可：
```
public class Client {

    public void auth(){

        Object object = new Object();
        Validator validator = new LoginValidator();
        validator.validate(object);

    }

}
```
这之后的链式操作会由验证器依次进行：
```
abstract public class Validator {
    protected Validator successor = null;

    public boolean validate(Object object){
        // 验证过程
        boolean isValid = false;
        if(isValid){
            return true;
        }else{
            if(this.successor != null){
                return this.successor.validate(object);
            }else{
                return false;
            }
        }
    }

    public void setSuccessor(Validator successor) {
        this.successor = successor;
    }
}
```
当然，我们也可以通过 `setter` 方法动态的设置责任链上的验证器后继节点。
### 命令模式（Command Pattern）
#### 介绍
命令模式将操作封装为类，使得对执行过程的撤销变得易于实现。

#### 缺点
由于操作都被封装为了类，因此项目中的代码量将会剧增。

#### 示例
对数据库的操作可以分为增删改查，当进行具体操作时，为了保证操作易于撤回，我们可以考虑使用命令模式进行实现。

#### 类图
![命令模式][17]
#### 核心代码
在客户端，可以使用 `Invoker` 执行命令：
```
public class Client {

    public void doSome(){
        Command commandA = new QueryCommand();
        Command commandB = new CreateCommand();
        Command commandC = new UpdateCommand();
        Command commandD = new DeleteCommand();

        Invoker invoker = new Invoker();
        invoker.invoke(commandA);
        invoker.invoke(commandB);
        invoker.undo();
        invoker.invoke(commandC);
        invoker.undo();
        invoker.invoke(commandD);
    }
}
```

`Invoker` 中的代码为：
```
public class Invoker {

    private History history = new History();

    public void invoke(Command command){
        this.history.add(command);
    }

    public void undo(){
        this.history.undo();
    }

}
```

在 `History` 中，对命令历史进行保存：
```
public class History {

    private Stack<Command> history = new Stack<>();

    public void undo(){
        Command command = history.pop();
        command.undo();
    }

    public void add(Command command){
        command.redo();
        this.history.push(command);
    }

}
```


### 解释器模式（Interpreter Pattern）
#### 介绍
对于自定义表达式的运算，需要涉及到对表达式的解析和执行过程。如此，可以考虑使用解释器模式。
#### 缺点
难以处理复杂的解释过程。
#### 示例
如自定义的中文加法运算的执行过程（一 + 一 ＝ 二），可以使用该模式。
#### 类图
![解释器模式][18]
#### 核心代码
将表达式分为终结表达式和非终结表达式，在解释过程中，用类似递归的方式进行解释：
```
public class AddExpression extends NonFinalExpression {
    @Override
    public int interpret(Context context) {
        int left = this.left.interpret(context);
        int right = this.right.interpret(context);
        return left + right;
    }
}
```

### 迭代器模式（Iterator Pattern）
#### 介绍
当希望能够在不暴露内部实现细节的情况下提供某一类的遍历手段时，可以考虑使用迭代器模式。

#### 缺点
迭代过程返回内部的对象，会造成封装性的破坏。

#### 示例
比如要遍历工资管理类中的全部工资清单，可以使用这一模式。

#### 类图
![迭代器模式][19]
#### 核心代码
将一个类变为可迭代的类（不同语言中实现的方式不同）：
```
public class SalaryCollection implements Iterator<Salary>{

    private Salary salaries[] = {
            new Salary(10000),
            new Salary(20000),
            new Salary(15000),
            new Salary(30000),
            new Salary(5000)
    };

    private Integer index = 0;

    @Override
    public boolean hasNext() {
        return index >= salaries.length;
    }

    @Override
    public Salary next() {
        return salaries[index++];
    }

}
```
然后在客户端对其进行遍历：
```
public class Client {

    public void doSome(){
        SalaryCollection collection = new SalaryCollection();
        int sum = 0;
        for (; collection.hasNext(); ) {
            Salary salary = collection.next();
            sum += salary.getValue();
        }

    }

}
```

### 仲裁者模式（Mediator Pattern）
#### 介绍
当多个对象之间均有交互请求，且交互逻辑较为复杂时，可以使用仲裁者模式形成对象间交互的中间层（仲裁者），用以解耦对象之间的显式依赖。
#### 缺点
显然，解耦的依赖转移到了仲裁者对象本身，使得当被仲裁对象发生变化时，仲裁者本身也必须响应该变化并进行修改。

#### 示例
系统中存在顾客、餐厅员工，以及配餐员三个角色，其中，餐厅员工会通知配餐员送餐；配餐员会告知顾客餐正在配送中；而顾客也可以向配送员或餐厅员工询问餐的进展。对于这种多个对象之间存在多种耦合的行为，可以考虑采用仲裁者模式实现。

#### 类图
![仲裁者模式][20]

#### 核心代码
在仲裁者模式中，请求均通过仲裁者对象进行，从而对各个对象进行了解耦：
```
public class Mediator {

    private Patron patron = new Patron();
    private Deliverer deliverer = new Deliverer();
    private Staff staff = new Staff();

    public void askForDeliverer(){
        this.deliverer.receiveAsk();
    }

    public void askForStaff(){
        this.staff.receiveAsk();
    }

    public void sendConfirm(){
        this.patron.getConfirm();
    }

    public void requestToDeliver(){
        this.deliverer.receiveRequest();
    }
}
```

### 备忘录模式（Memento Pattern）
#### 介绍
在不破坏封装性的情况下，对对象的内部信息进行保存。
#### 缺点
用于记录内部信息快照的备忘录对象本身是耗费资源的。
#### 示例
以下演示对于订单状态的备忘保存实现。
#### 类图
![备忘录模式][21]
#### 核心代码
`OrderHistory` 中负责记录订单的历史信息，存储的是 Memento 对象：
```
public class OrderHistory {

    private ArrayList<Memento> mementos = new ArrayList<>();

    public void store(Order order){
        Memento memento = order.createMemento();
        this.mementos.add(memento);
    }

    public void restore(Order order, int index){
        Memento memento = this.mementos.get(index);
        order.restore(memento);
    }

}
```
而订单类负责产生备忘录对象：
```
public class Order {

    private State state;

    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setState(this.state);
        return memento;
    }

    public void restore(Memento memento){
        this.state = memento.getState();
    }
}
```
注意，不能把历史信息直接存储在 `Order` 类中，因为一旦 `Order` 类生命周期结束，历史信息也会消失，这样是不合理的。

### 观察者模式（Observer Pattern）
#### 介绍
观察者模式是非常常用的一种设计模式。如果当某一事物发生改变时，这种行为会触发一系列的对象产生变化，此时就可以使用观察者模式来解耦这种一对多的对象关联关系。
#### 缺点
可能会导致观察者的级联更新。
#### 示例
不同的用户使用不同的方式（邮件、短信）注册了某一通知服务，当有新通知到达时，系统会基于不同的注册方式向注册用户发送通知。应对这一需求，可以使用观察者模式。
#### 类图
![观察者模式][22]

#### 核心代码
```
public class Publisher {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void publish(Message message){
        Iterator<Observer> iterator = this.observers.iterator();
        while (iterator.hasNext()){
            Observer observer = iterator.next();
            observer.update(message);
        }
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

}
```

### 状态模式（State Pattern）
#### 介绍
允许一个对象的具体行为随着内部状态的改变而改变。
#### 缺点
各个子状态间存在前后继的耦合关系。
#### 示例
对一个订单而言，其存在三种状态：准备、完成、配送。当处于准备状态时，订单需要进行加工操作；当处于完成状态时，需要执行通知以实现配送；当处于配送状态时，需要实时发布物流消息。对于这一需求，可以通过状态模式实现。
#### 类图
![状态模式][23]
#### 核心代码
客户端调用的方式为：
```
public class Client {

    public void doSome(){
        // 初始化，进入准备状态
        Order order = new Order();
        // 进入完成状态
        order.action();
        // 进入配送状态
        order.action();
        // 结束
    }

}
```
准备状态代码：
```
public class PrepareState implements State {
    @Override
    public void handle(Order order) {
        // 执行加工操作业务代码
        // ...
        // 转换状态
        order.setState(new FinishedState());

    }
}
```
结束状态代码：
```
public class FinishedState implements State {
    @Override
    public void handle(Order order) {
        // 执行通知操作业务代码
        // ...
        // 转换状态
        order.setState(new DeliveringState());
    }
}
```
配送状态代码：
```
public class DeliveringState implements State {
    @Override
    public void handle(Order order) {
        // 执行发布操作业务代码
        // ...
        // 转换状态
        order.setState(null);
    }
}
```

### 策略模式（Strategy Pattern）
#### 介绍
业务的具体算法可以在运行时确认和变动。即业务过程的策略可以进行设置和调整。
#### 缺点
调用方需要手动指定策略。引入策略会破坏封装性。
#### 示例
在要展示的列表数据处理逻辑中，对列表的排序操作存在多种策略，如按照姓名排序、按照年龄排序、按照薪资排序等。对于这种形式的需求，可以考虑采用策略模式进行实现。
#### 类图
![策略模式][24]
#### 核心代码
在使用方，手动指定策略：
```
public class Client {

    public void doSome(){
        DataViewer dataViewer = new DataViewer();
        SortStrategy strategyA = new SortByNameStrategy();
        SortStrategy strategyB = new SortByAgeStrategy();
        SortStrategy strategyC = new SortBySalaryStrategy();
        dataViewer.setStrategy(strategyA);
        // or
        dataViewer.setStrategy(strategyB);
        // or
        dataViewer.setStrategy(strategyC);

        dataViewer.render();
    }

}
```

### 模板方法模式（Template Method Pattern）
#### 介绍
将算法或逻辑的不变行为抽离出来，而将可变部分放在子类中实现。
#### 缺点
会产生较多的类。
#### 示例
在结账这一业务中，确认账单、获得账单这一过程是相同的，而选择支付方式是不同的。我们可以把这一需求采用模板方法模式进行实现。
#### 类图
![模板方法模式][25]
#### 核心代码
在客户端的调用方法如下：
```
public class Client {

    public void doSome(){
        PayOrder payOrderA = new PayOrderByCard();
        // or
        PayOrder payOrderB = new PayOrderByCash();
        payOrderA.check();
    }

}
```
`PayOrder` 中的实现为：
```
abstract public class PayOrder {

    final public void check(){
        this.confirm();
        this.pay();
        this.getBill();
    }

    // 确认
    private void confirm(){

    }

    // 获得账单
    private void getBill(){

    }

    // 子类中需要实现的方法
    abstract protected void pay();

}
```
### 访问者模式（Visitor Pattern）
#### 介绍
在不改变聚合对象元素行为的情况下，定义施加在聚合对象元素上的行为。
#### 缺点
聚合对象需要相对稳定。
#### 示例
订单分为即时订单和预购订单两类，当需要对订单的进行检查时，检查行为需要分别对这两类进行操作。此时，可以考虑使用访问者模式。
#### 类图
![访问者模式][26]
#### 核心代码
在 `Manager` 中，需要先设定访问者类型，然后对拥有订单的顾客 `Patron ` 进行订单检查：
```
public class Manager {

    public void doSome(){
        Patron patron = new Patron();
        Visitor visitorA = new VisitorImplA();
        // or
        Visitor visitorB = new VisitorImplB();

        patron.setVisitor(visitorA);
        patron.check();
    }

}
```
`Patron` 的代码为：
```
public class Patron {

    private List<Order> orders = new ArrayList<>();

    private Visitor visitor;

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void check(){
        Iterator<Order> iterator = this.orders.iterator();
        while (iterator.hasNext()){
            Order order = iterator.next();
            order.accept(this.visitor);
        }
    }

}
```
`Visitor` 实现类需要针对不同的 `Element` 进行对应的操作，代码为：
```
public class VisitorImplA implements Visitor {
    @Override
    public void visitOrder(Order order) {
        order.order();
    }

    @Override
    public void visitSubOrder(SubOrder subOrder) {
        subOrder.subOrder();
    }
}
```



## 参考
1. [软件设计模式 - 学堂在线][27]
2. [design-patterns-for-humans - github][28]
3. [了解软件设计模式概念 - 简书][29]
4. [面向对象的七种设计原则 - 博客园][30]
5. [设计模式五大原则（SOLID） - CSDN][31]
6. [GRASP通用职责分配软件模式][32]


  [1]: http://static.zybuluo.com/dailybird/n3aw6adekw828tqjnq35qeq0/image_1bdbemhi71k98gbu1kde19men49.png
  [2]: http://static.zybuluo.com/dailybird/p14oc7yrcuolguh2t9e8qyoh/image_1bdbfbpbq186k8us1f6714av1960m.png
  [3]: http://static.zybuluo.com/dailybird/1s2zozr2zc9troatcuzoh3ao/image_1bdbgib2ap3f1s2o1duuffh1dh413.png
  [4]: http://static.zybuluo.com/dailybird/6otsw06haoeatdkqgzix1uhs/image_1bdbhahaq1kmaj4bph5nb3jl41g.png
  [5]: http://static.zybuluo.com/dailybird/mq6krn7jm5be5n1j59up0yc8/image_1bdbis8k4ia5tas1adgaf81pmc1t.png
  [6]: http://static.zybuluo.com/dailybird/sb4q0ibjwo1emzbi3tm436n4/image_1bdbjnf121n863ni1l6a1talabu2a.png
  [7]: http://static.zybuluo.com/dailybird/pb2knhnrfphssc3v09ylzzd9/image_1bdbkulvr1rv3rft1clkpg7e4q2n.png
  [8]: http://static.zybuluo.com/dailybird/jj2anup8vtgvriy1iba3b7al/image_1bdbo93eu1aac1hr51g3638t1hb434.png
  [9]: http://static.zybuluo.com/dailybird/am3p4f81b9wpr3zkjb4oe6tf/image_1bdbpajc6i8eitn1r98cji6hq3h.png
  [10]: http://static.zybuluo.com/dailybird/u3b2wurahazwxbso8rhpwdif/image_1bdbqd8u014n41qus1rqu5dl4t13u.png
  [11]: http://static.zybuluo.com/dailybird/aj1iajye9av9hrp9wsoc0t57/image_1bdbr8f3vvundgl7hi1d2t1ti34b.png
  [12]: http://static.zybuluo.com/dailybird/gse9734ayjyrfse2i1eevb3f/image_1bdbsa3st1sto12ms5clahq1ms4o.png
  [13]: http://static.zybuluo.com/dailybird/t854cyvby9g6sxfrdgaefs29/image_1bdbsrru4s0mcfc6hui2vo3n55.png
  [14]: http://static.zybuluo.com/dailybird/0xl679b3bl1zqikg64uqyk0t/image_1bdbtlep21mj1e0u169h1ch3hpe5i.png
  [15]: http://static.zybuluo.com/dailybird/s9ujzp71ui46fabmojk4ul2j/image_1bdbu5j9bhs6193o13ptprk16dd5v.png
  [16]: http://static.zybuluo.com/dailybird/px37vqjt6of5dx7birn9qd8s/image_1bdbvvcsc1a4b11bq1p691bs41gd96p.png
  [17]: http://static.zybuluo.com/dailybird/9f33zyls5fsebrwc8ungxqbs/image_1bdc1fkfsegjgs21p231fu91osn76.png
  [18]: http://static.zybuluo.com/dailybird/ddafmyogl1eyz3qiu7dq24y0/image_1bdc2veg47d69mmf0r11ln1v9a7j.png
  [19]: http://static.zybuluo.com/dailybird/8apd8ntvvoo7hlmo3v8jijkf/image_1bdc40ign1hmg15eo1ac212ok1bt780.png
  [20]: http://static.zybuluo.com/dailybird/ghva4aufh9i5e2cifbaqyyu3/image_1bdc5omop2rd1t1vtl35da1qtf8d.png
  [21]: http://static.zybuluo.com/dailybird/n2crdta0xfs6xqsn1adoc9ux/image_1bdc85rncn8f9bn1f5s12om1uqv8q.png
  [22]: http://static.zybuluo.com/dailybird/ic5e80yfu2t5w7jm1960dqwc/image_1bdcdf8ca1pek4qo17oangc1n7897.png
  [23]: http://static.zybuluo.com/dailybird/pvp68jicxieypbaflnv1km73/image_1bdceh7tpsv11h941bao23qc0t9k.png
  [24]: http://static.zybuluo.com/dailybird/akysuacwkpktz86l7hvddzbk/image_1bdcff3g11p7ji2p1sd884516d2a1.png
  [25]: http://static.zybuluo.com/dailybird/mb4d9xntag9fucsyi0n7evit/image_1bdcg1l7apr21gdk13u91st71idtae.png
  [26]: http://static.zybuluo.com/dailybird/5ozpeifmjq6l7f70s1kwtf4u/image_1bdchcdmq44fpme1irv13a8177car.png
  [27]: http://www.xuetangx.com/courses/course-v1:USTC+USTC2006001+2017_T1/about
  [28]: https://github.com/questionlin/design-patterns-for-humans#-%E7%AE%80%E5%8D%95%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F
  [29]: http://www.jianshu.com/p/2e3e223faf28
  [30]: http://www.cnblogs.com/WuXuanKun/p/5386495.html
  [31]: http://m.blog.csdn.net/article/details?id=41930703
  [32]: http://www.aiuxian.com/article/p-2401824.html