package com.jab.microservices;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

@AnalyzeClasses(packages = "com.jab.microservices", importOptions = {ImportOption.DoNotIncludeTests.class})
public class OtherTests {

  @ArchTest
  final ArchRule noFieldInjection = fields()
      .should().notBeAnnotatedWith(Autowired.class)
      .andShould().notBeMetaAnnotatedWith(Autowired.class)
      .because("field injection is not allowed");

  @ArchTest
  final ArchRule noSetterInjection = methods()
      .should().notBeAnnotatedWith(Autowired.class)
      .andShould().notBeMetaAnnotatedWith(Autowired.class)
      .because("setter injection is not allowed");
}