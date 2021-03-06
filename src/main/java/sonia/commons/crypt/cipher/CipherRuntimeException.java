package sonia.commons.crypt.cipher;

/**
 *
 * @author Thorsten Ludewig <t.ludewig@ostfalia.de>
 * @since 1.1.0
 */
public class CipherRuntimeException extends RuntimeException
{

  /** Field description */
  private static final long serialVersionUID = 8090355061429525271L;

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   */
  public CipherRuntimeException() {}

  /**
   * Constructs ...
   *
   *
   * @param message
   */
  public CipherRuntimeException(String message)
  {
    super(message);
  }

  /**
   * Constructs ...
   *
   *
   * @param cause
   */
  public CipherRuntimeException(Throwable cause)
  {
    super(cause);
  }

  /**
   * Constructs ...
   *
   *
   * @param message
   * @param cause
   */
  public CipherRuntimeException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
