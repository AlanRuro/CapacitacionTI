package beanUtil;

public class GeneratorFilter {
    public GeneratorFilter(){}
        private static GeneratorFilter generatorFilter = null;
        protected static int filter;
        
        public static GeneratorFilter getGeneratorFilter(){
                if (generatorFilter == null){
                    synchronized(GeneratorFilter.class){
                        if (generatorFilter == null) { 
                            generatorFilter = new GeneratorFilter();
                        }
                    }
                }
                return generatorFilter;
        }
        
        public int getFilter(){
            if (filter <= 0){ filter = 1;
            }else {
                if (filter >= 5) filter = 1;
                else filter ++;
            }
            return filter;
        }
}
