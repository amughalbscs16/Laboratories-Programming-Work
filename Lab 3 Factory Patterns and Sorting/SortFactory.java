/**
 * A factory for sorting algorithms.
 */

public abstract class SortFactory {
 protected String algorithm;
 
 /**
  * The type of sorting algorithm we want to generate
  */
 public void setFactory(String algorithm) {
  this.algorithm = algorithm;
 }
 
 /**
  * This must generate the appropriate sorting algorithm
  * according to what was set in setFactory().
  */
 public abstract SortingAlgorithm getAlgorithm();
}
