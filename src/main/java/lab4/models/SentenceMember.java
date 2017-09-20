package lab4.models;

/**
 * Created by zhenia on 14.05.17.
 */
public interface SentenceMember {
    @Override
    String toString();

    SentenceMember reverse();
}
