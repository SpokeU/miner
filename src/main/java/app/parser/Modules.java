package app.parser;

import java.util.ArrayList;
import java.util.List;

public class Modules {

	public static List<StepModule> steps = new ArrayList();

	public class StepModule {
		public String key;
		public String name;
		public String processorClass;
		public String configuratorClass;
		public String viewTemplate;
		public String editTemplate;
		public String createTemplate;
	}

}
