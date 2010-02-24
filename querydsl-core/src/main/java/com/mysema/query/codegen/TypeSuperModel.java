/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.codegen;

import java.io.IOException;

import javax.annotation.Nullable;

/**
 * TypeSuperModel is a TypeModel for type variables and wildcard types
 * 
 * @author tiwe
 *
 */
public class TypeSuperModel extends TypeModelAdapter{
    
    private static final TypeModel objectModel = new ClassTypeModel(TypeCategory.SIMPLE, Object.class);
    
    private TypeModel superModel;
    
    @Nullable
    private String varName;
    
    public TypeSuperModel(String varName, TypeModel typeModel) {
        this(typeModel);
        this.varName = varName;
    }

    public TypeSuperModel(TypeModel typeModel) {
        super(objectModel);
        this.superModel = typeModel;
    }

    @Override
    public void getLocalGenericName(TypeModel context, Appendable builder, boolean asArgType) throws IOException {
        if (!asArgType){
            builder.append("? super ");
            superModel.getLocalGenericName(context, builder, true);
        }else{
            super.getLocalGenericName(context, builder, asArgType);
        }    
    }

}
