# Java开发规范

#### 1. 编码方式统一采用UTF-8

#### 2. 缩进统一为4个空格，将Tab size设置为4则可以保证tab键按4个空格缩进。另外，不要勾选上Use tab character，可以保证切换到不同tab长度的环境时还能继续保持统一的4个空格的缩进样式。

#### 3. 花括号不要单独一行，和它前面的代码同一行。而且，花括号与前面的代码之间用一个空格隔开。

```java
public void method() { // Good 

}

public void method()
{ // Bad
}

public void method(){ // Bad

}
```

#### 4. 空格的使用

```java
//if、else、for、switch、while等逻辑关键字与后面的语句留一个空格隔开。

// Good
if (booleanVariable) {
    // TODO while booleanVariable is true
} else {
    // TODO else
}

// Bad
if(booleanVariable) {
    // TODO while booleanVariable is true
}else {
    // TODO else
}
```

运算符两边各用一个空格隔开。

```java
	int result = a + b; //Good, = 和 + 两边各用一个空格隔开
	int result=a+b; //Bad,=和+两边没用空格隔开
```

方法的每个参数之间用一个空格隔开。

```java
	public void method(String param1, String param2); // Good，param1后面的逗号与String之间隔了一个空格
	method(param1, param2); // Good，方法调用时，param1后面的逗号与param2之间隔了一个空格
	method(param1,param2); // Bad，没有用一个空格隔开

```
#### 5. 空行的使用

将逻辑相关的代码段用空行隔开，以提高可读性。空行也只空一行，不要空多行。在以下情况需用一个空行：

*   两个方法之间
*   方法内的两个逻辑段之间
*   方法内的局部变量和方法的第一条逻辑语句之间
*   常量和变量之间

#### 6. 当一个表达式无法容纳在一行内时，可换行显示，另起的新行用8个空格缩进。

```java
	someMethod(longExpression1, longExpression2, longExpression3,
        longExpression4, longExpression5);
```

#### 7. 一行声明一个变量，不要一行声明多个变量，这样有利于写注释。

```java
private String param1; // 参数1
private String param2; // 参数2
```

#### 8. 使用快捷键进行代码自动格式化。

- Windows：CTRL+ALT+L
- Mac：OPTION+COMMAND+L

#### 9. 一个方法最多不要超过40行代码。

#### 10. 范围型的常量用枚举类定义，而不要直接用整型或字符，这样可以减少范围值的有效性检查。

```java
// 用枚举类定义，Good
public enum CouponType {
    // 现金券
    @SerializedName("1")
    CASH,

    // 抵用券
    @SerializedName("2")
    DEBIT,

    // 折扣券
    @SerializedName("3")
    DISCOUNT
}

// 用整型定义，Bad
public static final int TYPE_CASH = 1; // 现金券
public static final int TYPE_DEBIT = 2; // 抵扣券
public static final int TYPE_DISCOUNT = 3; // 折扣券
```

> ## 命名规范

#### 1. 包命名

域名反写+项目名称+模块名称，全部单词用小写字母。
例如，我的KAndroid项目的Model模块包名如下：

```
me.keeganlee.kandroid.model
```

#### 2. 类和接口命名

使用大驼峰规则，用名词或名词词组命名，每个单词的首字母大写。

#### 3. 方法命名

使用小驼峰规则，用动词命名，第一个单词的首字母小写，其他单词的首字母大写。
以下为几种常用方法的命名：

*   初始化方法，命名以init开头，例：initView
*   按钮点击方法，命名以to开头，例：toLogin
*   设置方法，命名以set开头，例：setData
*   具有返回值的获取方法，命名以get开头，例：getData
*   通过异步加载数据的方法，命名以load开头，例：loadData
*   布尔型的判断方法，命名以is或has，或具有逻辑意义的单词如equals，例：isEmpty

#### 4. 常量命名

全部为大写单词，单词之间用下划线分开。

```java
public final static int PAGE_SIZE = 20;
```

#### 5. 变量命名

{范围描述+}意义描述+类型描述的组合，用驼峰式，首字母小写。

```java
private TextView headerTitleTxt; // 标题栏的标题
private Button loginBtn; // 登录按钮
private CouponBO couponBO; // 券实例
```

> ## 注释规范

#### 1. 文件头注释

文件顶部统一添加版权声明，声明的格式如下：

```java
/**
 * Copyright (c) 2015. Keegan小钢 Inc. All rights reserved.
 */
```

#### 2. 类和接口注释

类和接口统一添加javadoc注释，格式如下：

```java
/**
 * 类或接口的描述信息
 *
 * @author ${USER}
 * @date ${DATE}
 */
```

#### 3. 方法注释

下面几种方法，都必须添加javadoc注释，说明该方法的用途和参数说明，以及返回值的说明。

*   接口中定义的所有方法
*   抽象类中自定义的抽象方法
*   抽象父类的自定义公用方法
*   工具类的公用方法
```java
/**
 * 登录
 *
 * @param loginName 登录名
 * @param password  密码
 * @param listener  回调监听器
 */
public void login(String loginName, String password, ActionCallbackListener<Void> listener);
```

#### 4. 变量和常量注释

下面几种情况下的常量和变量，都要添加注释说明，优先采用右侧//来注释，若注释说明太长则在上方添加注释。

*   接口中定义的所有常量
*   公有类的公有常量
*   枚举类定义的所有枚举常量
*   实体类的所有属性变量
```java
public static final int TYPE_CASH = 1; // 现金券
public static final int TYPE_DEBIT = 2; // 抵扣券
public static final int TYPE_DISCOUNT = 3; // 折扣券
private int id;                // 券id
private String name;           // 券名称
private String introduce;      // 券简介
```

> ## 结束语
这份开发规范说明比较细，也许还不是非常完整，但里面提到的每一条规范都很有用。按照此规范严格执行，将大大提高代码的可读性和维护性。