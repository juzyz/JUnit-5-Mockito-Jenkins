## **1. Test Doubles**
 
The project package com.mockito.juzyz.testdoubletypes contains examples of the usage of the following test doubles:

**Fakes** are objects that have working implementations, but not same as production one. Usually, they take some shortcut and have simplified version of production code.

**Dummy** — When we use an object to stand in place of a real object, but never make of the object, then the object is called a Dummy. It’s usually done to fill the parameter list, so that the code compiles and the compiler stays happy.

**Stub** is an object that holds predefined data and uses it to answer calls during tests. It is used when we cannot or don’t want to involve objects that would answer with real data or have undesirable side effects.

**Spy** objects are those that, in addition to being Stubs (that is, they return the desired predefined information) also record data on how they were called in some way.

**Mocks** are objects that register calls they receive and analyze the behavior. In test assertion we can verify on Mocks that all expected actions were performed.


## **2. Mock features**
