package com.jab.microservices.infrastructure.rest;

import com.tngtech.archunit.core.domain.JavaCodeUnit;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noCodeUnits;

@AnalyzeClasses(packages = "com.jab.microservices", importOptions = {ImportOption.DoNotIncludeTests.class})
public class ArchUnitTest {

    @ArchTest
    static ArchRule no_code_units_should_declare_exceptions = noCodeUnits()
            .should(new ArchCondition<JavaCodeUnit>("declare exceptions") {
                @Override
                public void check(JavaCodeUnit codeUnit, ConditionEvents events) {
                    int nThrowsDeclarations = codeUnit.getThrowsClause().size();
                    String message = String.format("%s has %d throws declarations in %s",
                            codeUnit.getDescription(), nThrowsDeclarations, codeUnit.getSourceCodeLocation()
                    );
                    events.add(new SimpleConditionEvent(codeUnit, nThrowsDeclarations > 0, message));
                }
            });

}
