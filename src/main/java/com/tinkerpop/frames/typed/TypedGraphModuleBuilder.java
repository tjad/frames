package com.tinkerpop.frames.typed;

import com.tinkerpop.frames.FramedGraphConfiguration;
import com.tinkerpop.frames.Module;

/**
 * TODO
 */
public class TypedGraphModuleBuilder {
	private TypeRegistry typeRegistry = new TypeRegistry();
	
	public TypedGraphModuleBuilder() {
		
	}
	
	public TypedGraphModuleBuilder add(Class<?> type) {
		typeRegistry.add(type);
		return this;
	}
	
	public Module build() {
		final TypeManager manager = new TypeManager(typeRegistry);
		return new Module() {
			
			@Override
			public void configure(FramedGraphConfiguration config) {
				
				
				config.addTypeResolver(manager);
				config.addFrameInitializer(manager);
			}

			
		};
	}
}
