package org.http4s.csp

/*
All the possible values for Content-Security-Policy sources.
See https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/Sources#sources
 */
sealed trait CSPSourceValue extends DirectiveValue

sealed class HostSource extends CSPSourceValue
sealed class SchemeSource extends CSPSourceValue
sealed class CSPSelf extends CSPSourceValue
sealed class UnsafeEval extends CSPSourceValue
sealed class UnsafeHashes extends CSPSourceValue
sealed class UnsafeInline extends CSPSourceValue
sealed class CSPNone extends CSPSourceValue
sealed class CSPNonce extends CSPSourceValue
sealed class CSPHash extends CSPSourceValue
sealed class ReportSample extends CSPSourceValue
