# HanLP Analysis for Elasticsearch
基于 [HanLP](https://github.com/hankcs/HanLP) 的 Elasticsearch 中文分词插件，核心功能：
1. 内置词典，无需额外配置即可使用；
2. 支持用户自定义词典；
3. 支持远程词典热更新；
4. 内置多种分词模式，适合不同场景。

## 内置分词器
### 分析器(Analysis)
- hanlp_index：细粒度切分
- hanlp_smart：常规切分
- hanlp_pinyin：拼音
- hanlp_array：数组
- hanlp_ngram：N切分
- hanlp_ts：繁简体
- hanlp：自定义

### 分词器(Tokenizer)
- hanlp_index：细粒度切分
- hanlp_smart：常规切分
- hanlp_pinyin：拼音
- hanlp_array：数组
- hanlp_ngram：N切分
- hanlp_ts：繁简体
- hanlp：自定义

### 过滤器(TokenFilter)
- hanlp_pinyin：拼音
- hanlp_ts：繁简体