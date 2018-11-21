import com.google.common.collect.ImmutableSet;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lombok.Data;
import org.bson.types.ObjectId;
import com.thanos.common.utils.BeanUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * Create by zhangzheng on 8/26/18
 * Email:zhangzheng@youzan.com
 */
public class Test {

  public static void main(String[] args) throws IllegalAccessException {
    T t1 = new T("a","b");
    T2 t2 = new T2("c","d");
    BeanUtils.copyProperties(t1, t2);
    System.out.println(">>>");


  }

  public void test(String a){


  }
  public static class T2{
    String a;
    String b;

    public T2(String a, String b) {
      this.a = a;
      this.b = b;
    }
  }

//  @Data
  public static class T{
    String a;
    String b;

    public T(String a, String b) {
      this.a = a;
      this.b = b;
    }
  }

}
