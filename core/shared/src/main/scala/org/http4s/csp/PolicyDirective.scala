package org.http4s.csp

object PolicyDirective {
  // TODO: implement properly, possibly in one of the RFC classes
  def parse(value: String): PolicyDirective = {
    PolicyDirective(
      new ScriptSrc,
      new CSPSelf
    )
  }
}

case class PolicyDirective(directive: Directive, value: DirectiveValue)

private[csp] trait Directive {
  // TODO - may need to make return type generic
  def parseValue(value: String): DirectiveValue
}

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/sandbox
sealed class Sandbox extends Directive {
  def parseValue(value: String): SandboxValue = new SandboxValue
}

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/frame-ancestors
sealed class FrameAncestors extends Directive {
  def parseValue(value: String): FrameAncestorSource = new FrameAncestorSource
}

//TODO: consider adding ReportUri. It's technically supposed to be deprecated, but a lot of major browsers still support report-uri and NOT report-to.
// See https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/report-uri for more details

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/report-to
sealed class ReportTo extends Directive {
  // TODO: values are whatever is valid for a JSON field name - figure out a good type for that
  def parseValue(value: String): ReportToValue = new ReportToValue
}

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/require-trusted-types-for
sealed class RequireTrustedTypesFor extends Directive {
  // Only possible value is "script" as of writing
  def parseValue(value: String): TrustedTypesSinkValue = new TrustedTypesSinkValue
}

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/trusted-types
sealed class TrustedTypes extends Directive {
  def parseValue(value: String): TrustedTypeValue = new TrustedTypeValue
}

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/upgrade-insecure-requests
sealed class UpgradeInsecureRequests extends Directive {
  //TODO: this is kind of a special case, as it has no value associated with it - just the directive name itself.
  // may need to make the value an option, or have a different base type (ie Directive and DirectiveNoValue)
  def parseValue(value: String): UpgradeInsecureRequestsValue = new UpgradeInsecureRequestsValue
}

private[csp] trait DirectiveValue
sealed class SandboxValue extends DirectiveValue
sealed class FrameAncestorSource extends DirectiveValue
sealed class ReportToValue extends DirectiveValue
sealed class TrustedTypesSinkValue extends DirectiveValue // TODO: consider naming closer to the directive this is for (requiretrustedtypesfor)
sealed class TrustedTypeValue extends DirectiveValue
sealed class UpgradeInsecureRequestsValue extends DirectiveValue

