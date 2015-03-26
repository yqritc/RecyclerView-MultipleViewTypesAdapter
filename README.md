# RecyclerView-MultipleViewTypeAdapter

RecyclerView adapter classes for managing multiple view types

 ![Sample](/sample/sample.gif)

# Release Note

[Release Note] (https://github.com/yqritc/RecyclerView-MultipleViewTypesAdapter/releases)

# Gradle
```
repositories {
    jcenter()
}

dependencies {
    compile 'com.yqritc:recyclerview-multiple-viewtypes-adapter:1.0.0'
}
```

# Usage

### 1. Create DataBinder
Define class extending DataBinder for each view type.  
DataBinder class is used to bind view and data.  
Please refer the [binder samples](/sample/src/main/java/com/yqritc/recyclerviewmultipleviewtypesadapter/sample/binder) for usage.

### 2. Create DataBindAdapter
Create adapter class to manage DataBinder classes.  
Use (or extend) ListBindAdapter if the order of view types used for recyclerview is in sequence.  
If the order of view types is complex, create class by extending EnumMapBindAdapter or DataBindAdapter.  
Please refer the [adapter samples](/sample/src/main/java/com/yqritc/recyclerviewmultipleviewtypesadapter/sample/adapter) for usage.

### 3. Set adapter for recyclerview

# License
```
Copyright 2015 yqritc

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
