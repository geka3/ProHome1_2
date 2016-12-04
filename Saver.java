import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 1 on 04.12.2016.
 */
public class Saver {



    public static void main(String[] args){
        Class<?> cls = TextContainer.class;
        try{
            TextContainer tc = (TextContainer) cls.newInstance();

            if (cls.isAnnotationPresent(SaveTo.class)){
                System.out.println("there is annotation");
                SaveTo anSaveTo = cls.getAnnotation(SaveTo.class);
                System.out.println("path is " + anSaveTo.path());


                Method [] methods = cls.getDeclaredMethods();
                for(Method method : methods){
                    if(method.isAnnotationPresent(SaverMethod.class)){
                        method.setAccessible(true);
                        method.invoke(tc,anSaveTo.path());

                    }
                }


            }else{
                System.out.println("annotation no found");
            }


        }catch(InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }










    }
}
