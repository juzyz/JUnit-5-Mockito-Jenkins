## 1. Test Doubles
 
The project package **com.mockito.juzyz.testdoubletypes** contains examples of the usage of the following test doubles:

**Fakes** are objects that have working implementations, but not same as production one. Usually, they take some shortcut and have simplified version of production code.

**Dummy** — When we use an object to stand in place of a real object, but never make of the object, then the object is called a Dummy. It’s usually done to fill the parameter list, so that the code compiles and the compiler stays happy.

**Stub** is an object that holds predefined data and uses it to answer calls during tests. It is used when we cannot or don’t want to involve objects that would answer with real data or have undesirable side effects.

**Spy** objects are those that, in addition to being Stubs (that is, they return the desired predefined information) also record data on how they were called in some way.

**Mocks** are objects that register calls they receive and analyze the behavior. In test assertion we can verify on Mocks that all expected actions were performed.


## 2. Mock features

The project package **com.mockito.juzyz.mockfeatures** contains examples of the usage of mock features such as:

2.1 Basic features like when() -> thenReturn(), doReturn() -> when(), doNothing() and overriding equals method for stubbing purpose.

2.2 Exception testing for negative scenarios with assertThrow, doThrow and assertThrows methods.

2.3 Behavior verification involves checking whether a method is invoked or not,

```
verify(bookRepository).save(book);
 verifyNoMoreInteractions(bookRepository);
```

counting the number of invocations, 

``` 
verify(bookRepository, never()).save(book);
verify(bookRepository, atLeast(1)).save(book);
```

and examining the values of input parameters used during invocation

```
verify(bookRepository).findBookById("123");
```

2.4 Argument Captor that used to capture argument values for further assertions

```
@Captor
private ArgumentCaptor<Book> bookArgumentCaptor;

verify(bookRepository).save(bookArgumentCaptor.capture());
Book book = bookArgumentCaptor.getValue();
assertEquals("Mockito In Action", book.getTitle());
```

2.5 Argument Matchers are used as wildcards to specify a range of input types rather than a specific input.

```
when(bookRepository.findBookById(any())).thenReturn(book1);
when(bookRepository.findBookById(any(String.class))).thenReturn(book1);
when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book);
when(bookRepository.findBookByTitleAndDescriptopn(startsWith("Mockito"), contains("action"),)).thenReturn(book);
```

## 3 Spy 
The project package **com.mockito.juzyz.spies** contains examples of the usage of spies that allow to call all real methods of the object while still tracking every interaction using Mockito.spy() and doReturn() methods.

## 4 Behavior Driven Development
