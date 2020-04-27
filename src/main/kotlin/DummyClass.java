public class DummyClass {
    public Integer doAction(IDummyAction<Integer> action) {
        return action.doAction(1);
    }
}
