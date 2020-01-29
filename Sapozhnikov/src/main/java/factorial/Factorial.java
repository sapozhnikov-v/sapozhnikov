package factorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Factorial {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args){
        int n = 7;
        int x = 1;
            for (int i=1; i<n+1; i++){
                x=x*i;
                logger.info("Вычисление произведено");
            }
        System.out.println(x);
            logger.info("Результат выведен на экран");
        }
    }

