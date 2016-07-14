#!/usr/bin/env ruby

require 'mojinizer'

resources = File.expand_path('../src/main/resources', File.dirname(__FILE__))

romaji_to_katakana = {}
romaji_to_hiragana = {}
kana_to_romaji = {}

romaji_to_katakana.merge!(Mojinizer::ROM_TO_KATA1)
romaji_to_katakana.merge!(Mojinizer::ROM_TO_KATA2)
romaji_to_katakana.merge!(Mojinizer::ROM_TO_KATA3)

romaji_to_katakana.merge!({
  'n' => 'ン', 
  'm' => 'ン',
  'n\'' => 'ン',
  'dzu' => 'ヅ'
})

romaji_to_katakana.each do |romaji, katakana|
  romaji_to_hiragana[romaji] = katakana.kata_to_hira
end

kana_to_romaji.merge!(romaji_to_katakana.invert)
kana_to_romaji.merge!(romaji_to_hiragana.invert)
kana_to_romaji.merge!(Mojinizer::KANA_TO_ROM)
kana_to_romaji.merge!(Mojinizer::KANA_TO_ROM2)

kana_to_romaji.merge!({
  'ン' => 'n',
  'ん' => 'n',
  'ンア' => 'n\'a',
  'んあ' => 'n\'a',
  'ンイ' => 'n\'i',
  'んい' => 'n\'i',
  'ンウ' => 'n\'u',
  'んう' => 'n\'u',
  'ンエ' => 'n\'e',
  'んえ' => 'n\'e',
  'ンオ' => 'n\'o',
  'んお' => 'n\'o',
  'ンヤ' => 'n\'ya',
  'んや' => 'n\'ya',
  'ンユ' => 'n\'yu',
  'んゆ' => 'n\'yu',
  'ンヨ' => 'n\'yo',
  'んよ' => 'n\'yo',
  'じゃ' => 'ja',
  'ジャ' => 'ja',
  'じゅ' => 'ju',
  'ジュ' => 'ju',
  'じぇ' => 'je',
  'ジェ' => 'je',
  'じょ' => 'jo',
  'ジョ' => 'jo'
})

kana_to_romaji.delete 'っ'
kana_to_romaji.delete 'ッ'

File.open(File.join(resources, 'romaji_to_katakana.csv'), 'w') do |file|
  romaji_to_katakana.each { |k, v| file.puts "#{k},#{v}" }
end

File.open(File.join(resources, 'romaji_to_hiragana.csv'), 'w') do |file|
  romaji_to_hiragana.each { |k, v| file.puts "#{k},#{v}" }
end

File.open(File.join(resources, 'kana_to_romaji.csv'), 'w') do |file|
  kana_to_romaji.each { |k, v| file.puts "#{k},#{v}" }
end

