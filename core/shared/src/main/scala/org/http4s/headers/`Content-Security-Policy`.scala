package org.http4s.headers

import org.http4s.csp.PolicyDirective
import cats.parse.Parser0
import org.http4s.{Header, ParseResult}
import org.http4s.internal.parsing.Rfc7230
import org.typelevel.ci._

/*
See https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy
 */
object `Content-Security-Policy` {
  def parse(s: String): ParseResult[`Content-Security-Policy`] =
    ParseResult.fromParser(parser, "Invalid Content-Security-Policy header")(s)

  private[http4s] val parser: Parser0[`Content-Security-Policy`] =
    Rfc7230.headerRep(Rfc7230.token.map(PolicyDirective.parse)).map(`Content-Security-Policy`(_))

  implicit val headerInstance: Header[`Content-Security-Policy`, Header.Recurring] =
    Header.createRendered(
      ci"Accept-CH",
      _.policyDirectives,
      parse,
    )

  implicit val headerSemigroupInstance: cats.Monoid[`Content-Security-Policy`] =
    cats.Monoid.instance(
      `Content-Security-Policy`(Nil),
      (one, two) => `Content-Security-Policy`(one.policyDirectives ++ two.policyDirectives),
    )
}

final case class `Content-Security-Policy`(policyDirectives: List[PolicyDirective])
