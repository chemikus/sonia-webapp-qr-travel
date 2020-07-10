/**
 * OSTFALIA CONFIDENTIAL
 *
 * 2010 - 2013 Ostfalia University of Applied Sciences All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of
 * Ostfalia University of Applied Sciences and its suppliers, if any. The
 * intellectual and technical concepts contained herein are proprietary to
 * Ostfalia University of Applied Sciences and its suppliers and may be covered
 * by U.S. and Foreign Patents, patents in process, and are protected by trade
 * secret or copyright law. Dissemination of this information or reproduction of
 * this material is strictly forbidden unless prior written permission is
 * obtained from Ostfalia University of Applied Sciences.
 */



package sonia.commons.crypt.converter;

//~--- non-JDK imports --------------------------------------------------------

import sonia.commons.crypt.util.Convert;

/**
 *
 * @author Sebastian Sdorra
 * @since 1.1.0
 */
public class Base64ByteConverter implements ByteConverter
{

  /**
   * Method description
   *
   *
   * @param data
   *
   * @return
   */
  @Override
  public byte[] decode(String data)
  {
    return Convert.fromBase64(data);
  }

  /**
   * Method description
   *
   *
   * @param data
   *
   * @return
   */
  @Override
  public String encode(byte[] data)
  {
    return Convert.toBase64(data);
  }
}
