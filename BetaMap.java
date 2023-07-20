import java.security.Key;

public class BetaMap <K, V>{
    BetaList<BetaList<Pair<K, V>>> map = new BetaList<>();
    BetaList<K> keys = new BetaList<>();

    public int hashKey(K key){
        return 0;
    }

    public void put(K key, V value){
        int index = hashKey(key) % (map.size() + 1);
        Pair<K, V> kvPair = new Pair<>(key, value);
        BetaList<Pair<K, V>> kvChain = map.get(index);

        if (kvChain == null){
            BetaList<Pair<K, V>> newChain = new BetaList<>();
            newChain.append(kvPair);
            map.append(newChain);
        }
        else {
            if (keys.contains(kvPair.key)) {
                updateValue(kvChain, key, value);
            } else
                map.get(index).append(kvPair);
        }
        keys.append(kvPair.key);
    }

    private void updateValue(BetaList<Pair<K, V>>chain, K key, V value){
        for (int i = 0; i < chain.size(); i++) {
            Pair<K, V> kvPair = chain.get(i);
            if (kvPair.key.equals(key)){
                kvPair.value = value;
                break;
            }
        }
    }

    public V get(K key) throws Exception{
        int index = hashKey(key);
        BetaList<Pair<K, V>> kvChain = map.get(index);

        for (int i = 0; i < kvChain.size(); i++) {
            Pair<K, V> kvPair = kvChain.get(i);
            if (kvPair.key.equals(key)) {
                return kvPair.value;
            }
        }
        throw new Exception("Key not found");
    }

    public int size(){
        int sz = 0;

        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) == null)
                continue;
            sz += map.get(i).size();
        }
        return sz;
    }

    public void remove(K key){
        int index = hashKey(key);
        BetaList<Pair<K, V>> kvChain = map.get(index);

        for (int i = 0; i < kvChain.size(); i++) {
            Pair<K, V> kvPair = kvChain.get(i);
            if (kvPair.key == key){
                kvChain.remove(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String stringFormat = "{";

        for (int i = 0; i < map.size(); i++) {
            BetaList<Pair<K, V>> kvChain = map.get(i);
            if (kvChain.isEmpty())
                continue;
            for (int j = 0; j < kvChain.size(); j++) {
                stringFormat += kvChain.get(j).toString() + ", ";
            }
        }

        stringFormat += "}";

        return stringFormat;
    }
}
