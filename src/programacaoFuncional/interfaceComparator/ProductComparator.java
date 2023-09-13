package programacaoFuncional.interfaceComparator;

import java.util.Comparator;

public class ProductComparator implements Comparator<Produto> { // implementacao da interface Comparator
    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
