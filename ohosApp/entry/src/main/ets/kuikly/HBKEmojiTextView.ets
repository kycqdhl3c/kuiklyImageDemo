import { KRAny, KuiklyRenderBaseView, KuiklyRenderCallback } from '@kuikly-open/render';
import { ComponentContent, LengthMetrics } from '@kit.ArkUI';

@Observed
export class HBKEmojiTextView extends KuiklyRenderBaseView {
  static readonly VIEW_NAME = 'HBKEmojiText';
  content: string = ""
  syncViewSizeCallback?: KuiklyRenderCallback

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
  Text((view as HBKEmojiTextView).content)
    .backgroundColor(Color.Red)
    .onSizeChange((oldSize, newSize) => {
      console.log(`>>>> onSizeChange oldSize: ${oldSize.width}-${oldSize.height}, newSize: ${newSize.width}-${newSize.height}`)
    })
    .onAreaChange((oldSize, newSize) => {
      console.log(`>>>> onAreaChange oldSize: ${oldSize.width}-${oldSize.height}, newSize: ${newSize.width}-${newSize.height}`)
    })
}