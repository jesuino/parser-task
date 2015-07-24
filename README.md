Parser Service Task
--

This is a jbpm 6 service task to parse XML/JSON to objects and the inverse.


~~~
import org.drools.core.process.core.datatype.impl.type.StringDataType;
import org.drools.core.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.process.core.datatype.impl.type.BooleanDataType;

 [
    "name" : "Parser",
    "parameters" : [
        "Format" : new StringDataType(),
        "Type" : new StringDataType(),
        "Input" : new ObjectDataType(),
        "To Object" : new BooleanDataType()
    ],
    "results" : [
        "Result" : new ObjectDataType(),
    ],
    "displayName" : "Parser",
    "icon" : "parser_icon.png"
  ]
~~~