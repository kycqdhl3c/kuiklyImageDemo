import { KRAny, KuiklyRenderBaseView, KuiklyRenderCallback } from '@kuikly-open/render';
import { ComponentContent, LengthMetrics } from '@kit.ArkUI';

@ObservedV2
export class HBKEmojiTextView extends KuiklyRenderBaseView {
  static readonly VIEW_NAME = 'HBKEmojiText';
  content: string = ""
  syncViewSizeCallback?: KuiklyRenderCallback
  @Trace
  scrollWidth: Length = 0
  @Trace
  scrollHeight: Length = 0

  call(_method: string, _params: KRAny, _callback: KuiklyRenderCallback | null): void {
  }

  createArkUIView(): ComponentContent<KuiklyRenderBaseView> {
    return new ComponentContent<KuiklyRenderBaseView>(this.getUIContext()!,
      wrapBuilder<[KuiklyRenderBaseView]>(createEmojiTextView), this)
  }

  setProp(propKey: string, propValue: KRAny | KuiklyRenderCallback): boolean {
    switch (propKey) {
      case "text": {
        this.content = propValue as string
        return true
      }
      default:
        return super.setProp(propKey, propValue);
    }
  }
}

@Builder
function createEmojiTextView(view: KuiklyRenderBaseView) {
  Stack() {
    Scroll() {
      Text((view as HBKEmojiTextView).content)
        .fontColor(Color.Black)
        .backgroundColor(Color.Red)
        .onSizeChange((oldSize, newSize) => {
          console.log(`>>>> onSizeChange oldSize: ${oldSize.width}-${oldSize.height}, newSize: ${newSize.width}-${newSize.height}`)
        })
        .onAreaChange((oldSize, newSize) => {
          console.log(`>>>> onAreaChange oldSize: ${oldSize.width}-${oldSize.height}, newSize: ${newSize.width}-${newSize.height}`);
          (view as HBKEmojiTextView).scrollWidth = newSize.width;
          (view as HBKEmojiTextView).scrollHeight = newSize.height
        })
    }.backgroundColor(Color.Blue)
    .width(300)
    .height(300)
    // .width((view as HBKEmojiTextView).scrollWidth == 0 ? "auto" : (view as HBKEmojiTextView).scrollWidth)
    // .height((view as HBKEmojiTextView).scrollHeight == 0 ? "auto" : (view as HBKEmojiTextView).scrollHeight)
  }
  // .width((view as HBKEmojiTextView).scrollWidth == 0 ? "auto" : (view as HBKEmojiTextView).scrollWidth)
  // .height((view as HBKEmojiTextView).scrollHeight == 0 ? "auto" : (view as HBKEmojiTextView).scrollHeight)
}