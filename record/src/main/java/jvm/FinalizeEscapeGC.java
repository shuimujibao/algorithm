package jvm;

/**
 * @author sunxiaoyu3
 * @description 一次对象自我拯救
 * <p>对象可以在发生GC时自我拯救</p>
 *
 * <p>这种自救机会只有一次，因为对象的finalize()方法只能被系统自动调用一次</p>
 * @createTime 2020/10/10 10:26:00
 */
public class FinalizeEscapeGC {

    private static FinalizeEscapeGC SAVE_HOOK = null;

    private void isAlive() {
        System.out.println("I am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;

        System.gc();

        //因为finalize优先级很低，所以先暂停0.5秒等待他
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead!");
        }

        //对象第二次拯救自己，同样的代码 拯救失败

        SAVE_HOOK = null;

        System.gc();

        //因为finalize优先级很低，所以先暂停0.5秒等待他
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead!");
        }
    }
}
