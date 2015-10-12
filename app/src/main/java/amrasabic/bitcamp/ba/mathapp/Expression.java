package amrasabic.bitcamp.ba.mathapp;

/**
 * Created by stvorenje on 10/11/15.
 */
public class Expression {

    private int mExpressionId;
    private int mExpressionResult;

    public Expression(int expressionId, int expressionResult) {
        mExpressionId = expressionId;
        mExpressionResult = expressionResult;
    }

    public int getExpressionId() {
        return mExpressionId;
    }

    public void setExpressionId(int expressionId) {
        mExpressionId = expressionId;
    }

    public int getExpressionResult() {
        return mExpressionResult;
    }

    public void setExpressionResult(int expressionResult) {
        mExpressionResult = expressionResult;
    }
}
