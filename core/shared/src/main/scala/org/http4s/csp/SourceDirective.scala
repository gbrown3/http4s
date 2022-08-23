package org.http4s.csp

/*
A directive with one or more CSP sources as values
 */
sealed trait SourceDirective extends Directive {

  // TODO - may need to make return type generic
  def parseValue(value: String): CSPSourceValue = new CSPSelf
}

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/child-src
sealed class ChildSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/connect-src
sealed class ConnectSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/default-src
sealed class DefaultSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/font-src
sealed class FontSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/frame-src
sealed class FrameSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/img-src
sealed class ImgSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/manifest-src
sealed class ManifestSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/media-src
sealed class MediaSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/object-src
sealed class ObjectSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/prefetch-src
sealed class PrefetchSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/script-src
sealed class ScriptSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/script-src-elem
sealed class ScriptSrcElem extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/script-src-attr
sealed class ScriptSrcAttr extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/style-src
sealed class StyleSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/style-src-elem
sealed class StyleSrcElem extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/style-src-attr
sealed class StyleSrcAttr extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/worker-src
sealed class WorkerSrc extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/base-uri
sealed class BaseUri extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/form-action
sealed class FormAction extends SourceDirective

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/navigate-to
sealed class NavigateTo extends SourceDirective
