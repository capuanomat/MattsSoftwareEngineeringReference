/**
 * Created by Matthieu J.B Capuano on 10/20/2017.
 */
public class key_value_pair_example<K, V> {
    private boolean removed;
    private K key;
    private V value;

    public mapElem(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
